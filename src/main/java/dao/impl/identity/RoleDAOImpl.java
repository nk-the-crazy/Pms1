package dao.impl.identity;

import dao.impl.common.GenericDAOImpl;
import model.identity.Role;

import org.springframework.stereotype.Repository;

import dao.api.identity.RoleDAO;


@Repository
public class RoleDAOImpl extends GenericDAOImpl<Role>  implements RoleDAO
{

    public RoleDAOImpl()
    {
        super( Role.class );
    }

}
