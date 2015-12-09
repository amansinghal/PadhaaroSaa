package com.padhaarosaa.Model;

import java.io.Serializable;
/**
 * Created by gspl on 12/9/2015.
 */
public class Merriages implements Serializable
{
    private String id;

    private CoupleName CoupleName;

    private String userId;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public CoupleName getCoupleName ()
    {
        return CoupleName;
    }

    public void setCoupleName (CoupleName CoupleName)
    {
        this.CoupleName = CoupleName;
    }

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", CoupleName = "+CoupleName+", userId = "+userId+"]";
    }
}
