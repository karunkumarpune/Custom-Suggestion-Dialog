package com.dialogs.search_api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import ir.mirrajabi.searchdialog.core.Searchable;

public class UserModel implements Searchable {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("lastName")
@Expose
private String lastName;
@SerializedName("age")
@Expose
private Integer age;
@SerializedName("phoneNumbers")
@Expose
private List<String> phoneNumbers = null;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public Integer getAge() {
return age;
}

public void setAge(Integer age) {
this.age = age;
}

public List<String> getPhoneNumbers() {
return phoneNumbers;
}

public void setPhoneNumbers(List<String> phoneNumbers) {
this.phoneNumbers = phoneNumbers;
}

    @Override
    public String getTitle() {
        return null;
    }
}