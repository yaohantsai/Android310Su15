package com.uw.android310.lesson5;

/**
<<<<<<< HEAD
 * Created by JT on 2015/7/20.
 */
public class Weather {
    private  static Weather Rest_CLIENT;

    private int id;
    private String main;
    private String description;
    private  String icon;

    public int getId()
    {
        return id;
    }
    public  void setId(int id){
        this.id=id;
    }
    public  String getDescription(){
        return description;
    }

=======
// * Created by DOu on 7/20/15.
// */
public class Weather {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//>>>>>>> upstream/development
}
