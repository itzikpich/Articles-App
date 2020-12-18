package com.itzikpichhadze.zemingoapp.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "rss", strict = false)
public class ArticleResponse {

    @Element(name = "channel")
    public Channel channel;



}
