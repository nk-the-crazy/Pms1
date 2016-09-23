package model.common;

public enum PermissionObject
{
    IdentityManagement(1),
    CompanyManagement(2),
    PersonManagement(3),
    FinanceManagement(4),
    ProductManagement(5),
    SalesManagement(6);

    private final static int groupId = 2;
    private int id;


    private PermissionObject(  int id)
    {
        this.id = id;
    }

    public int getGroupId()
    {
        return groupId;
    }

    public int getId()
    {
        return id;
    }
}
