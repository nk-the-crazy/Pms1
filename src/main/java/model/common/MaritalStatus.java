package model.common;

public enum MaritalStatus
{
    Single(1),
    Married(2);

    private final static int groupId = 2;
    private int id;


    private MaritalStatus( int id )
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
