package com.boxproject.backend.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Integer activity_id;
    private String activity_name;
    private String activity_city;
    private String activity_address;
    private String activity_state;
    private Integer activity_price;
    private Integer activity_rating;
    private String activity_owner_name;
    private long activity_ownwer_mobile;
    private String activity_owner_address;
    @ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name = "Activity_Slot",
            joinColumns={
                    @JoinColumn(name="activity_id_ref",referencedColumnName="activity_id")
            },
            inverseJoinColumns={
                    @JoinColumn(name="slot_id_ref",referencedColumnName="slot_id")
            }
    )
//    @JsonManagedReference
    private Set<Slots> slots;

    public Integer getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(Integer activity_id) {
        this.activity_id = activity_id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_city() {
        return activity_city;
    }

    public void setActivity_city(String activity_city) {
        this.activity_city = activity_city;
    }

    public String getActivity_address() {
        return activity_address;
    }

    public void setActivity_address(String activity_address) {
        this.activity_address = activity_address;
    }

    public String getActivity_state() {
        return activity_state;
    }

    public void setActivity_state(String activity_state) {
        this.activity_state = activity_state;
    }

    public Integer getActivity_price() {
        return activity_price;
    }

    public void setActivity_price(Integer activity_price) {
        this.activity_price = activity_price;
    }

    public Integer getActivity_rating() {
        return activity_rating;
    }

    public void setActivity_rating(Integer activity_rating) {
        this.activity_rating = activity_rating;
    }

    public String getActivity_owner_name() {
        return activity_owner_name;
    }

    public void setActivity_owner_name(String activity_owner_name) {
        this.activity_owner_name = activity_owner_name;
    }

    public long getActivity_ownwer_mobile() {
        return activity_ownwer_mobile;
    }

    public void setActivity_ownwer_mobile(long activity_ownwer_mobile) {
        this.activity_ownwer_mobile = activity_ownwer_mobile;
    }

    public String getActivity_owner_address() {
        return activity_owner_address;
    }

    public void setActivity_owner_address(String activity_owner_address) {
        this.activity_owner_address = activity_owner_address;
    }

    public Set<Slots> getSlots() {
        return slots;
    }

    public void setSlots(Set<Slots> slots) {
        this.slots = slots;
    }
}