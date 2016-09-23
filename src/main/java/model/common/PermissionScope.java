package model.common;

public enum PermissionScope
{
    AllObject(1),
    OwnerObjects(2);

    private final static int groupId = 2;
    private int id;


    private PermissionScope(  int id)
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
