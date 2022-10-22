package com.yap.retrofitsample.Project1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("support")
    @Expose
    private Support support;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

//    String page;
//    String per_page;
//    String total;
//    String total_pages;
//    ArrayList<data>  data;
//
//    public String getPage() {
//        return page;
//    }
//
//    public void setPage(String page) {
//        this.page = page;
//    }
//
//    public String getPer_page() {
//        return per_page;
//    }
//
//    public void setPer_page(String per_page) {
//        this.per_page = per_page;
//    }
//
//    public String getTotal() {
//        return total;
//    }
//
//    public void setTotal(String total) {
//        this.total = total;
//    }
//
//    public String getTotal_pages() {
//        return total_pages;
//    }
//
//    public void setTotal_pages(String total_pages) {
//        this.total_pages = total_pages;
//    }
//
//    public ArrayList<Model.data> getData() {
//        return data;
//    }
//
//    public void setData(ArrayList<Model.data> data) {
//        this.data = data;
//    }
//
//
//    //for array object of data
//    public class data {
//        String id;
//        String email;
//        String first_name;
//        String last_name;
//        String avatar;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getFirst_name() {
//            return first_name;
//        }
//
//        public void setFirst_name(String first_name) {
//            this.first_name = first_name;
//        }
//
//        public String getLast_name() {
//            return last_name;
//        }
//
//        public void setLast_name(String last_name) {
//            this.last_name = last_name;
//        }
//
//        public String getAvatar() {
//            return avatar;
//        }
//
//        public void setAvatar(String avatar) {
//            this.avatar = avatar;
//        }
//    }
}


