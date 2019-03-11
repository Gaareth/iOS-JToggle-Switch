# iOS-JToggle-Switch
A Java library, that adds a new JToggleButton looking like a iOS Switch

It will probably look like this: 

![Will look like this:](http://i.imgur.com/nlwTIdu.png)


Settings: Width= 200, Autosize= True, ovalsize= 6


## Usage ##

This is a simple Example.

```java
iOS_ToggleButton switch = new iOS_ToggleButton();
switch.setBounds(x, y, width, height);
```

## Customizable ##

You can also adjust the styling a bit.
For Example: 
```java
iOS_ToggleButton switch = new iOS_ToggleButton(10,true); 
```
The Arguments **ovalsize** and **autosizing** 
* ovalSize: regulates circle size.
* autoSizing: Sets the height to something more beautiful :D.
