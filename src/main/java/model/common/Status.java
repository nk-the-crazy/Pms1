package model.common;

/**
 *
 */
public enum Status
{
    Active(1),
    Disabled(2);

    private final static int groupId = 1;
    private int id;


    private Status(  int id)
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
