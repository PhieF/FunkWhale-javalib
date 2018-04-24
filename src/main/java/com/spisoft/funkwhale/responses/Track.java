package com.spisoft.funkwhale.responses;

/**
 * Created by phoenamandre on 24/04/18.
 */

public class Track {
   // {"id":9176,"mbid":"8fe33778-18ec-479b-95c8-30837cfc762c","title":"Bora","artist":{"id":268,"mbid":"5fb94de9-6534-48e8-acd7-ee81f8604432","name":"Rone","tags":[],"creation_date":"2018-03-02T23:13:27.886863Z"},"files":[],"album":{"id":1003,"mbid":"e72c5b84-5479-4e80-a814-e63b6a2637f3","title":"Bora","release_date":"2008-02-01","cover":"https://funkwhale.eliotberriot.com:443/media/albums/covers/2018/04/23/e72c5b84-5479-4e80-a814-e63b6a2637f3.jpg"},"tags":[],"lyrics":"/api/v1/tracks/9176/lyrics/"}
    public long id;
    public String mbid;
    public String title;
    public Artist artist;
    public Album album;
    public String[] files;
    public String[] tags;
    public String lyrics;
}
