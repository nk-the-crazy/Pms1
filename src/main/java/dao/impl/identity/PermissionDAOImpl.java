package dao.impl.identity;

import dao.api.identity.PermissionDAO;
import dao.impl.common.GenericDAOImpl;
import model.identity.Permission;

public class PermissionDAOImpl extends GenericDAOImpl<Permission>  implements PermissionDAO
{
    public PermissionDAOImpl()
    {
        super( Permission.class );
    }

}
