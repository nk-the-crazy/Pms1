package model.common;

public enum CompanyType
{
    SoleTrader(1),
    LLC(2),   //Limited Liability Company)
    OJSC(3),  //Open Joint-Stock Company
    CJSC(4);   //Closed Joint-Stock Company
    

    private final static int groupId = 20;
    private int id;


    private CompanyType( int id )
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
