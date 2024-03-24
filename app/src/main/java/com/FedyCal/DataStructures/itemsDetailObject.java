package com.FedyCal.DataStructures;

import java.util.List;

/**
 * Here the details of the movie or tvSeries are stored. They don't have exactly the same parameters,
 * I can understand that it is a tv series if the title is equal to "", otherwise it is a movie.
 * This is because the title of the tv series is stored on the variable name.
 */

public class itemsDetailObject {

    //MOVIE DETAILS
    String adult = "";
    String backdrop_path ="";
    String budget = "";
    String homepage = "";
    String id = "";
    String imdb_id = "";
    String original_language = "";
    String original_title = "";
    String overview = "";
    String popularity = "";
    String poster_path= "";
    List<Generes> generesList;
    /*
    "belongs_to_collection": {
        "id": 263,
        "name": "The Dark Knight Collection",
        "poster_path": "/hGvOMQBD88jAV0olS2DT1AxreHn.jpg",
        "backdrop_path": "/xfKot7lqaiW4XpL5TtDlVBA9ei9.jpg"
    },
        */
    /*
    "production_companies": [{
             "id": 9996,
             "logo_path": "/3tvBqYsBhxWeHlu62SIJ1el93O7.png",
             "name": "Syncopy",
             "origin_country": "GB"
         },
         {
             "id": 923,
             "logo_path": "/5UQsZrfbfG2dYJbx8DxfoTr2Bvu.png",
             "name": "Legendary Pictures",
             "origin_country": "US"
         },
         {
             "id": 9993,
             "logo_path": "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
             "name": "DC Entertainment",
             "origin_country": "US"
         },
         {
             "id": 174,
             "logo_path": "/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png",
             "name": "Warner Bros. Pictures",
             "origin_country": "US"
         }
     ],
     "production_countries": [{
         "iso_3166_1": "US",
         "name": "United States of America"
     }],
     */
    String release_date ="";
    String revenue = "";
    String runtime = "";
    /*
    "spoken_languages": [{
        "english_name": "English",
        "iso_639_1": "en",
        "name": "English"
    }],
     */
    String status = "";
    String tagline ="";
    String title ="";
    String video ="";
    String vote_average = "";
    String vote_count = "";

    public String getAdult() {
        return adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getBudget() {
        return budget;
    }

    public List<Generes> getGeneresList() {
        return generesList;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRevenue() {
        return revenue;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getVote_count() {
        return vote_count;
    }



    //SHOW DETAIL
    String first_air_date = "";
    String in_production = "";
    String last_air_date = "";
    String name = "";
    String number_of_episodes = "";
    String number_of_seasons = "";
    String original_name = "";
    String type = "";

    /*

    "next_episode_to_air":null,

    "created_by": [
    {
        "id": 113733,
            "credit_id": "5257302e760ee3776a33b78e",
            "name": "Britt Allcroft",
            "gender": 0,
            "profile_path": null
    },
    {
        "id": 1230803,
            "credit_id": "5257302f760ee3776a33b796",
            "name": "Reverend W. Awdry",
            "gender": 0,
            "profile_path": null
    },
    {
        "id": 1230804,
            "credit_id": "52573031760ee3776a33b79e",
            "name": "Christopher Awdry",
            "gender": 0,
            "profile_path": null
    }
    ],
    "episode_run_time": [
        17
    ],
    "genres": [
        {
            "id": 16,
            "name": "Animation"
        },
        {
            "id": 10762,
            "name": "Kids"
        }
    ],
    "languages": [
        "en"
    ],

    "last_episode_to_air": {
            "air_date": "2021-01-20",
            "episode_number": 20,
            "id": 2556423,
            "name": "Thomas' Animal Friends",
            "overview": "",
            "production_code": "",
            "season_number": 24,
            "still_path": null,
            "vote_average": 0.0,
            "vote_count": 0
        },

    "networks": [
        {
            "name": "ITV",
            "id": 9,
            "logo_path": "/5Rmw4ViYcjW14PCdOyjsue9eK99.png",
            "origin_country": "GB"
        },
        {
            "name": "Cartoon Network",
            "id": 217,
            "logo_path": "/nDFWFbAHEZ8Towq7fsVCgv4U245.png",
            "origin_country": "GB"
        }
    ],
    "origin_country": [
        "GB"
    ],
    "production_companies": [
        {
            "id": 46875,
            "logo_path": null,
            "name": "Nitrogen Studios Canada",
            "origin_country": "CA"
        }
    ],
    "production_countries": [],
    "seasons": [
        {
            "air_date": "2008-09-01",
            "episode_count": 98,
            "id": 7209,
            "name": "Specials",
            "overview": "",
            "poster_path": "/7Gwe4ElMIhwS1Oq1xSp6x5y4KXp.jpg",
            "season_number": 0
        },
        {
            "air_date": "1984-10-09",
            "episode_count": 26,
            "id": 7196,
            "name": "Season 1",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the first series, which was originally broadcast in 1984. This series was initially narrated by Ringo Starr for the UK audiences, who re-dubbed 25 episodes for the US audiences; which was later re-dubbed again by George Carlin for the US audiences.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.\n\nAll episodes from this series can be found on the DVD release Thomas: The Early Years, released by Anchor Bay Entertainment/HIT Entertainment in 2004.\n\nIt was produced by Clearwater Features Ltd. for Britt Allcroft Ltd.",
            "poster_path": "/dL3NAa6ZHpTv9SmRUrLEEXYEnoZ.jpg",
            "season_number": 1
        },
        {
            "air_date": "1986-09-02",
            "episode_count": 26,
            "id": 7197,
            "name": "Season 2",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the second series of the show, which was first broadcast in 1986. This series was initially narrated by Ringo Starr for the UK audiences, who re-dubbed 16 episodes for the US audiences; which was later re-dubbed again by George Carlin for the US audiences.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.\n\nThis was the last series to be narrated by Ringo Starr, as well as the last series to be produced by Robert D. Cardona.\n\nIt was produced by Clearwater Features Ltd. for Britt Allcroft Ltd.",
            "poster_path": "/mmpsRcDK3DrSEAH0AUSS7kN8JkQ.jpg",
            "season_number": 2
        },
        {
            "air_date": "1991-09-12",
            "episode_count": 26,
            "id": 7198,
            "name": "Season 3",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the third series of the show, which was first broadcast in 1991. This series was narrated by Michael Angelis for the UK audiences, while George Carlin narrated the episodes for the US audiences.\n\nSome episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.",
            "poster_path": "/jpc6lquXZax4ZZ07xnBrOUhF3VD.jpg",
            "season_number": 3
        },
        {
            "air_date": "1994-09-10",
            "episode_count": 26,
            "id": 7199,
            "name": "Season 4",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the fourth series of the show, which was first broadcast in 1994. This series was narrated by Michael Angelis for the UK audiences, with George Carlin narrating the episodes for the US audiences, which was also his last series.\n\nSome episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath. It was produced by Britt Allcroft Limited.",
            "poster_path": "/6PVG6L2JYa4UmQJFISTD5xreXRp.jpg",
            "season_number": 4
        },
        {
            "air_date": "1998-08-21",
            "episode_count": 26,
            "id": 7200,
            "name": "Season 5",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the fifth Series of the show, which was first broadcast in 1998. This Series is narrated by Michael Angelis for the UK audiences, although Alec Baldwin narrated the episodes for the US audiences.\n\nThis was the first Series to use the Dolby Surround sound technique.\n\nThis was the last Series to be produced by Britt Allcroft.\n\nIt was produced by Britt Allcroft Limited.",
            "poster_path": "/wXLSjOcN80XAwEzpMnxvAddVo2W.jpg",
            "season_number": 5
        },
        {
            "air_date": "2003-01-06",
            "episode_count": 26,
            "id": 7201,
            "name": "Season 6",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the sixth Series of the show, which was first broadcast in 2002. This series was narrated by Michael Angelis for the UK audiences, who also re-dubbed only 2 episodes for the US audiences, although Alec Baldwin narrated the episodes for the US audiences, which was also his last series. Eight were re-dubbed by Michael Brandon for the US audiences.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.",
            "poster_path": "/dn1iXHQuB9TmZOm30diDv1X5dal.jpg",
            "season_number": 6
        },
        {
            "air_date": "2003-11-03",
            "episode_count": 26,
            "id": 7202,
            "name": "Season 7",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the seventh series of this show, which was first broadcast in 2003. This Series is narrated by Michael Angelis for the UK audiences, who re-dubbed only four episodes for the US audiences, although Michael Brandon narrated the episodes for the US audiences.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.",
            "poster_path": "/5NcgV7STkzU6z8hAOhHcvNsnAUT.jpg",
            "season_number": 7
        },
        {
            "air_date": "2004-08-01",
            "episode_count": 26,
            "id": 7203,
            "name": "Season 8",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the eighth series of the show, which was first broadcast in 2004. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences.",
            "poster_path": "/vuAwps9dpR4DQelFa9Di0m9lSIM.jpg",
            "season_number": 8
        },
        {
            "air_date": "2005-09-04",
            "episode_count": 26,
            "id": 7204,
            "name": "Season 9",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the ninth Series of this show, which was first broadcast in 2005. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrated the episodes for the US audiences.\n\nSome episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.\n\nStarting in this series, at the beginning of each show, the characters' numbers would appear on each cab starting from Henry to Edward to Thomas as the countdown, the workmen would then get Thomas ready for the new day and Thomas' driver would signal the workmen that Thomas is ready by blowing Thomas' whistle and Thomas would start his adventures. Towards the end of each show, the countdown would begin again, Thomas would return to the station, the workmen would get Thomas ready for tomorrow, and Thomas would go to sleep with a white sleeping cap with blue stripes on his funnel. In later seasons, these sketches would be shortened because the series would be funded by LEGO Duplo.",
            "poster_path": "/kGrmnGCtrbOmLZYfIaPRPoXXOCF.jpg",
            "season_number": 9
        },
        {
            "air_date": "2006-10-02",
            "episode_count": 28,
            "id": 7205,
            "name": "Season 10",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis was Jocelyn Stevenson's last series as executive producer.\n\nThis was Sharon Miller's first season as head writer.\n\nThis article lists episodes from the tenth Series of this show, which was first broadcast in 2006. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrated the episodes for the US audiences. In fact, it was first broadcast in America under Brandon's narration.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.",
            "poster_path": "/8kuYjZ1uqOPMPXylRaa7GdrAzs5.jpg",
            "season_number": 10
        },
        {
            "air_date": "2007-09-03",
            "episode_count": 26,
            "id": 7206,
            "name": "Season 11",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the eleventh series of this show, which was first broadcast in 2007. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences.\n\nStarting in this Series, the theme song is sung by the kids from the \"Thomas and Friends\" suite.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.\n\nThis was Christopher Skala's first series as executive producer.\n\nThis is the last Series to be distributed by CPTV.",
            "poster_path": "/7bNxhLrNGXRZoAPsqAGexYK41J8.jpg",
            "season_number": 11
        },
        {
            "air_date": "2008-09-01",
            "episode_count": 20,
            "id": 7207,
            "name": "Season 12",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the twelfth series of the show, which was first broadcast in 2008. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences.\n\nMost episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.",
            "poster_path": "/ijcm4segDjHh3a1dNnltBAtzVbv.jpg",
            "season_number": 12
        },
        {
            "air_date": "2010-01-25",
            "episode_count": 20,
            "id": 7208,
            "name": "Season 13",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the thirteenth series of the show, which was first broadcast in 2010. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences.\n\nThis was Marion Edwards' first series as executive producer.\n\nFollowing the release of feature-length special DVD Hero of the Rails in September 2009 and the theatrical and video releases of select episodes. This series introduces computer-generated imagery as a replacement for the show's long-standing model animation, as well as a voice cast rather than an individual actor's narration.",
            "poster_path": "/lIRRPXa8RurCByVNh0vNfaVriw4.jpg",
            "season_number": 13
        },
        {
            "air_date": "2010-10-11",
            "episode_count": 20,
            "id": 7211,
            "name": "Season 14",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the fourteenth series of the show, which was first broadcast in 2010. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences.",
            "poster_path": "/hmymbZvjFrga6eUwst5aRV18TFi.jpg",
            "season_number": 14
        },
        {
            "air_date": "2011-03-01",
            "episode_count": 20,
            "id": 7210,
            "name": "Season 15",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis was Christopher Skala's last series as executive producer.\n\nThis article lists and details episodes from the fifteenth series of the show, which was first broadcast in 2011. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences.\n\nRupert Degas joins the voice cast.",
            "poster_path": "/x7ombYdbdpdT00vVnVc17HgDtSi.jpg",
            "season_number": 15
        },
        {
            "air_date": "2012-02-20",
            "episode_count": 20,
            "id": 7212,
            "name": "Season 16",
            "overview": "Thomas & Friends is a children's television series about the engines and other characters working on the railways of the Island of Sodor, and is based on The Railway Series books written by the Rev. W. Awdry.\n\nThis article lists and details episodes from the sixteenth series of the show, which was first broadcast in 2012. This series was narrated by Michael Angelis for the UK audiences, although Michael Brandon narrates the episodes for the US audiences, which was their last series.\n\nThis series was the final series to have Sharon Miller and Sam Barlow as head writer and story executive and the final series for Nitrogen Studios.\n\nSome episodes in this series have two titles: the original titles from the UK broadcasts are shown on top, while the American-adapted titles are shown underneath.",
            "poster_path": "/cMRVMLYFDdAIOhHXnOn6pTbolzw.jpg",
            "season_number": 16
        },
        {
            "air_date": "2013-06-03",
            "episode_count": 26,
            "id": 7213,
            "name": "Season 17",
            "overview": "The seventeenth season of the television series premiered in the UK on June 3rd, 2013. It then stopped airing after ten episodes and resumed airing on September 30th, 2013. It stopped again after a week of episodes. One episode aired on November 5th and four more aired in December. The remaining six episodes went straight to DVD in the UK and US in March 2014. Four of the final episodes aired on July 5th and 6th in the UK. In the US, the season started airing on October 17th. This season is the first of a new writing style for the series and ran for twenty-six episodes. ",
            "poster_path": "/8WgIRYUNjmrQyHUIbXFCddqq5gK.jpg",
            "season_number": 17
        },
        {
            "air_date": "2014-08-25",
            "episode_count": 26,
            "id": 81340,
            "name": "Season 18",
            "overview": "The eighteenth season of the television series began airing on August 25th, 2014 in the UK and on November 4th, 2014 in the US. It contained twenty-six episodes. Like the seventeenth season, five episodes were released on DVD in the US before airing on television. It concluded in the UK on July 31st, 2015.",
            "poster_path": "/qhIQ2PnxA8fcs6GsHorStypPjnm.jpg",
            "season_number": 18
        },
        {
            "air_date": "2015-09-21",
            "episode_count": 26,
            "id": 81355,
            "name": "Season 19",
            "overview": "",
            "poster_path": "/z4puLFvYB0xbZj4fUqGlMFSE4s5.jpg",
            "season_number": 19
        },
        {
            "air_date": "2016-09-05",
            "episode_count": 28,
            "id": 81364,
            "name": "Season 20",
            "overview": "",
            "poster_path": "/qPRNJUg8J8YOPiCgLkqNtAzlasB.jpg",
            "season_number": 20
        },
        {
            "air_date": "2017-09-18",
            "episode_count": 18,
            "id": 145866,
            "name": "Season 21",
            "overview": "",
            "poster_path": "/25PDPpUxdE8EsuR3m57y3di0efd.jpg",
            "season_number": 21
        },
        {
            "air_date": "2018-09-03",
            "episode_count": 26,
            "id": 145868,
            "name": "Season 22",
            "overview": "",
            "poster_path": "/5oR1XLxsqmc075ZqdromIKvFXg9.jpg",
            "season_number": 22
        },
        {
            "air_date": "2019-09-02",
            "episode_count": 23,
            "id": 160526,
            "name": "Season 23",
            "overview": "",
            "poster_path": "/8VllwNr3ZAQRHRJAQ6AuXkmq7cu.jpg",
            "season_number": 23
        },
        {
            "air_date": "2020-09-07",
            "episode_count": 23,
            "id": 160529,
            "name": "Season 24",
            "overview": "",
            "poster_path": "/1lHEiJBo9hBqHaVjnVzC7VYdBRA.jpg",
            "season_number": 24
        },
        {
            "air_date": null,
            "episode_count": 0,
            "id": 182356,
            "name": "Season 25",
            "overview": "",
            "poster_path": "/j95eK6JuOtUGxhacvqYiXW8WjE9.jpg",
            "season_number": 25
        }
    ],
    "spoken_languages": [
        {
            "english_name": "English",
            "iso_639_1": "en",
            "name": "English"
        }
    ],
     */

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getIn_production() {
        return in_production;
    }

    public String getLast_air_date() {
        return last_air_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber_of_episodes() {
        return number_of_episodes;
    }

    public String getNumber_of_seasons() {
        return number_of_seasons;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}





