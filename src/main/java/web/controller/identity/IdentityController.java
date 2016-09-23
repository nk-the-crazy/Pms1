package web.controller.identity;


import java.util.List;

import javax.servlet.http.HttpSession;
import model.common.session.SessionData;
import model.company.Company;
import model.identity.Role;
import model.identity.User;
import service.api.identity.IdentityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import common.exceptions.security.InvalidLoginException;
import web.view.ModelView;


@Controller
public class IdentityController
{
    //---------------------------------
    private static final Logger logger = LoggerFactory.getLogger(IdentityController.class);
    //---------------------------------

    
    @Autowired
	private IdentityManager identityManager;
    
    @Autowired  
    private MessageSource messageSource;

	
	
	/*******************************************************
	 * 
	 * */
	@RequestMapping( "/" )
	public String login()
	{
		return ModelView.VIEW_LOGIN_PAGE;
	}
	
	
	/*******************************************************
	 * 
	 * */
	@RequestMapping( "/main.vw" )
	public String mainView()
	{
		return ModelView.VIEW_MAIN_PAGE;
	}
	
	
	/*******************************************************
	 * 
	 */
	@RequestMapping( value = "/logout.do", method = RequestMethod.GET )
	public String logoutUser( HttpSession session )
	{
		session.removeAttribute( "sessionData" );
		return ModelView.VIEW_LOGIN_PAGE;
	}
	
	
	/*******************************************************
	 * 
	 * */
	@RequestMapping( value = "/login.do", method = RequestMethod.POST )
	public ModelAndView loginUser( @RequestParam( "username" ) String userName, @RequestParam( "password" ) String password, HttpSession session )
	{
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
		
		try
		{
	        SessionData sData = identityManager.loginUser( userName, password );
    		
    		if ( sData != null )
    		{
    			User user = identityManager.getUserDetails( sData.gerUser().getId());
    		    session.setAttribute( "sessionData", sData );
    			model.addObject( "userDetails", user );
    			model.setViewName( ModelView.VIEW_MAIN_PAGE);
    		}
    		else
    		{
    		    throw new InvalidLoginException("Invalid Login");
    		}
    		
		}
        catch(InvalidLoginException e)
        {
            logger.error( " **** Invalid Login ", e );        
            model.addObject( "loginMessage", messageSource.getMessage( "message.error.invalid_login",null, null));
            model.setViewName( ModelView.VIEW_LOGIN_PAGE);
        }
		catch(Exception e)
		{
            logger.error( " **** Error authenticating user", e );        
            model.addObject( "loginMessage", messageSource.getMessage( "message.error.invalid_login",null, null));
            model.setViewName( ModelView.VIEW_LOGIN_PAGE);
		}
		
		return model;
		
	}
	

    /*******************************************************
     * 
     */
    @RequestMapping( value = "/edit_password.vw")
    public ModelAndView changePasswordView()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            model.setViewName( ModelView.VIEW_EDIT_PASSWORD_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting user list:", e );        
        }
        
        return model;
        
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/user_details.vw")
    public ModelAndView getUserDetailsView(@RequestParam( "user_id" ) long userId)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            User user = identityManager.getUserDetails( userId);
            model.addObject( "userDetails", user );
            model.setViewName( ModelView.VIEW_USER_DETAILS_PAGE);
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting user Details:", e );        
        }
        
        return model;
        
    }
    
    
    /*******************************************************
     * 
     * */
    @RequestMapping( value = "/edit_password.do", method = RequestMethod.POST )
    public ModelAndView changeUserPassword( @RequestParam( "old_password" ) String oldPassword,
                                            @RequestParam( "new_password" ) String newPassword, HttpSession session)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            SessionData sData = (SessionData)session.getAttribute( "sessionData" );
            
            if(sData == null)
            {
                model.setViewName( ModelView.VIEW_EDIT_PASSWORD_PAGE);
            }
            else
            {
                if(identityManager.changeUserPassword( sData.gerUser(), oldPassword, newPassword ))
                {
                    model.setViewName( ModelView.VIEW_MAIN_PAGE);
                }
                else
                {
                    model.setViewName( ModelView.VIEW_EDIT_PASSWORD_PAGE);
                }
            }
        }
        catch(Exception e)
        {
            logger.error( " **** Error changing password:", e );        
        }
        
        return model;
        
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/user_list.vw")
    public ModelAndView getUserList()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            List<User> users = identityManager.getUserList();
            
            model.addObject( "userList", users );
            model.setViewName( ModelView.VIEW_USER_LIST_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting user list:", e );        
        }
        
        return model;
        
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/role_list.vw")
    public ModelAndView roleListView()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            List<Role> roles = identityManager.getRoleList();
            
            model.addObject( "roleList", roles );
            model.setViewName( ModelView.VIEW_ROLE_LIST_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting role list:", e );        
        }
        
       return model;
        
    }
    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/role_details.vw", method = RequestMethod.GET)
    public ModelAndView getCompanyFullDetails(@RequestParam( "role_id" ) long roleId )
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            Role role = identityManager.getRoleById( roleId );
            
            if(role != null)
            {
                model.addObject( "roleDetails", role );
            }
            
            model.setViewName( ModelView.VIEW_ROLE_DETAILS_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting role details", e );        
        }
        
        return model;
        
    }
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/register_role.vw", method = RequestMethod.GET)
    public ModelAndView registerRoleView()
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            model.setViewName( ModelView.VIEW_ROLE_REGISTER_PAGE);
        }
        catch(Exception e)
        {
            logger.error( " **** Error getting role details", e );        
        }
        
        return model;
        
    }
    
    
    /******************************************************
     * 
     */
    @RequestMapping( value = "/register_role.do", method = RequestMethod.POST )
    public ModelAndView registerRole( @ModelAttribute( "role" ) Role role)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            role = identityManager.addRole( role );
            
            if ( role != null )
            {
                return roleListView();
            }
            else
            {
                model.setViewName( ModelView.VIEW_ROLE_REGISTER_PAGE);
            }
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering role:", e );        
            model.setViewName( ModelView.VIEW_ROLE_REGISTER_PAGE);
        }
        
        return model;
        
    }

    
    
    /*******************************************************
     * 
     */
    @RequestMapping( value = "/register_user.vw", method = RequestMethod.GET )
    public ModelAndView registerUser(@RequestParam( "company_id" ) long companyId, 
                                     @RequestParam( "person_id" ) long personId)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            Company company  = identityManager.getCompanyInfo( companyId, personId );
            List<Role> roles = identityManager.getRoleList(); 
            
            model.addObject( "companyInfo", company);
            model.addObject( "roles", roles);
            model.setViewName( ModelView.VIEW_USER_REGISTER_PAGE);
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error opening register user page:", e );        
        }
        
        return model;
        
    }
    
    
    /******************************************************
     * 
     */
    @RequestMapping( value = "/remove_role.do", method = RequestMethod.GET)
    public ModelAndView removeRole( @RequestParam( "role_id" ) long roleId)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            identityManager.removeRoleById( roleId );
            return roleListView();
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering role:", e );        
            model.setViewName( ModelView.VIEW_ROLE_REGISTER_PAGE);
        }
        
        return model;
        
    }

    
    
    /******************************************************
     * 
     */
    @RequestMapping( value = "/register_user.do", method = RequestMethod.POST )
    public ModelAndView registerPerson( @ModelAttribute( "user" ) User user,
                                        @RequestParam( "company_id" ) long companyId, 
                                        @RequestParam( "person_id" ) long personId,
                                        @RequestParam( "role_ids" ) List<Long> roleIds)
    {
        ModelAndView model = new ModelAndView( ModelView.VIEW_MAIN_PAGE );
        
        try
        {
            user = identityManager.addUser( user, companyId, personId, roleIds );
            
            if ( user != null )
            {
                return getUserList();
            }
            else
            {
                model.setViewName( ModelView.VIEW_USER_REGISTER_PAGE);
            }
            
        }
        catch(Exception e)
        {
            logger.error( " **** Error registering user:", e );        
            model.setViewName( ModelView.VIEW_USER_REGISTER_PAGE);
        }
        
        return model;
        
    }

}