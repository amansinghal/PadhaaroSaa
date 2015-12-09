package com.padhaarosaa.Model;

import java.io.Serializable;
/**
 * Created by gspl on 12/9/2015.
 */
public class CoupleName implements Serializable
{
    private String groomName;

    private String brideName;

    public String getGroomName ()
    {
        return groomName;
    }

    public void setGroomName (String groomName)
    {
        this.groomName = groomName;
    }

    public String getBrideName ()
    {
        return brideName;
    }

    public void setBrideName (String brideName)
    {
        this.brideName = brideName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [groomName = "+groomName+", brideName = "+brideName+"]";
    }
}