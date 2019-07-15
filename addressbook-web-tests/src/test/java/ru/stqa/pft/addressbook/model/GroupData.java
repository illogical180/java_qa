package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {

    private int Id;
    private final String name;
    private final String header;
    private final String footer;

       public GroupData(int Id, String name, String header, String footer) {
        this.Id = Id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }
    public GroupData(String name, String header, String footer) {
        this.Id = 0;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public int getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Id == groupData.Id &&
                Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name);
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "Id='" + Id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
    public void setId(int id) {
        Id = id;
    }

}
