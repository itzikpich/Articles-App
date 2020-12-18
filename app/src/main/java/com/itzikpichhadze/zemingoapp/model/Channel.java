package com.itzikpichhadze.zemingoapp.model;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "channel", strict = false)
public class Channel {

    @ElementList(inline = true, name="item")
    public List<Article> articles;
}