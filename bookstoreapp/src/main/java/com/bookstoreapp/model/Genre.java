package com.bookstoreapp.model;

@Enitiy
@Table (name = "Genre")
public class Genre {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  String name;

    @Column
    private  String subGenre;

    @ManyToMany
    Set<Book>books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubGenre() {
        return subGenre;
    }

    public void setSubGenre(String subGenre) {
        this.subGenre = subGenre;
    }

    public Genre (Long id, String name, String subGenre){
        this.id = id;
        this.name = name;
        this.subGenre = subGenre;
    }

    public Genre(){
        //default
    }

}
