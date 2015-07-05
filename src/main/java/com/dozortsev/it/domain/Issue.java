package com.dozortsev.it.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    private String name;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override public String toString() {
        return "Issue{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
