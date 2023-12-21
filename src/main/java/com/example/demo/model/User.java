package com.example.demo.model;

public class User {
    private Long id;
    private String name;
    private String email;

    public User() {

    }

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "User{" +
                "id= " + id +
                ", name = '" + name + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof User)) return false;
        User user = (User) o ;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }
}
