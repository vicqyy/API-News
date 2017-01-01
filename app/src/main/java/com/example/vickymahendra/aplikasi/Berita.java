package com.example.vickymahendra.aplikasi;

/**
 * Created by Vicky Mahendra on 12/31/2016.
 */


public class Berita {

    private String author;
    private String description;
    private String title;
    private String url;
    private String image;

    public Berita() {
        // TODO Auto-generated constructor stub
    }

    public Berita(String author, String description, String title, String url,
                  String image) {
        super();
        this.author = author;
        this.description = description;
        this.title = title;
        this.url = url;
        this.image = image;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
