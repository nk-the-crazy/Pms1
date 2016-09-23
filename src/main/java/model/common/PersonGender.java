package model.common;

public enum PersonGender
{
    Male(1),
    Female(2);

    private final static int groupId = 3;
    private int id;


    private PersonGender( int id )
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
