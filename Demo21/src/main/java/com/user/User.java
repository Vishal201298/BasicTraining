package com.user;

public class User {
 private String id;
 private String username,password,type;
public String getId() {
	return id;
}
//public void setId(String id) {
//	this.id = id;
//}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
@Override
public String toString() {
	return "User [ username=" + username + ", password=" + password + ", type=" + type + "]";
}
public void setPassword(String password) {
	this.password = password;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
 
}