package com.hmn.simplemovieslist.utils

import com.hmn.simplemovieslist.R

object Util {
    const val BASE_URL = "https://newshealthtracker.com/playstore/assets/json/TollywoodVideoSongs/"
    val DB_NAME = "Latest.DB"
    val KEY_DB_LATEST_DATE = "latest_date"


    val newList by lazy {
        mutableListOf<NewList>().apply {
            add(
                NewList(
                    "Irumbuthirai | Azhagae Video Song | Vishal, Arjun, Samantha | Yuvan Shankar Raja",
                    R.drawable.one,"WOEMkG3gOKI"
                )
            )

            add(
                NewList(
                    "airii - What Are You Talking Lady",
                    R.drawable.two,"f6Cswdm601A"
                )
            )

            add(
                NewList(
                    "Sketch | Kanave Kanave Video Song | Chiyaan Vikram, Tamannaah",
                    R.drawable.three,"8EJ3zbKTWQ8&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=2"
                )
            )

            add(
                NewList(
                    "Sketch | Atchi Putchi Full Video Song | Chiyaan Vikram | Vijay Chandar | Thaman S",
                    R.drawable.four,"vuq-VAiW9kw&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=3"
                )
            )

            add(
                NewList(
                    "ulaebaghavali || Prabhu Deva, Hansika | Vivek Mervin",
                    R.drawable.five,"09R8_2nJtjg&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=4"
                )
            )

            add(
                NewList(
                    "Thaanaa Serndha Koottam - Peela Peela Tamil Video| Suriya | Anirudh l Keerthi Suresh",
                    R.drawable.six,"m-M1AtrxztU&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=5"
                )
            )

            add(
                NewList(
                    "Thaanaa Serndha Koottam - Sodakku Tamil Video | Suriya | Anirudh l Keerthi Suresh",
                    R.drawable.seven,"Dkk9gvTmCXY&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=6"
                )
            )

            add(
                NewList(
                    "Notanki HD Video Song | Power | Raviteja | Hansika | Regina",
                    R.drawable.eight,"FKXSh14svlQ&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=7"
                )
            )

            add(
                NewList(
                    "Vaa Vaa Vaa Vennila - Official Video Song | Aambala | Vishal,Hansika",
                    R.drawable.nine,"ru0K8uYEZWw&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=8"
                )
            )

            add(
                NewList(
                    "Vaalu Songs | UR My Darling Video Song | STR | Hansika Motwani | Santhanam",
                    R.drawable.eleven,"Y66j_BUCBMY&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=9"
                )
            )

            add(
                NewList(
                    "Bogan - Senthoora Video | Jayam Ravi, Hansika | Imman",
                    R.drawable.twelve,"ZQPSRQtABdU&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=10"
                )
            )

            add(
                NewList(
                    "Gulaebaghavali | Seramal Ponal Video Song | 4K | Kalyaan | Prabhu Deva, Hansika",
                    R.drawable.thirteen,"SFySVeyv4I0&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=11"
                )
            )
            add(
                NewList(
                    "Gulaebaghavali | Seramal Ponal Video Song | 4K | Kalyaan | Prabhu Deva, Hansika",
                    R.drawable.fourteen,"JGwWNGJdvx8&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=12"
                )
            )
            add(
                NewList(
                    "Most Wanted Abbayi Video Song Making | MLA Movie | Nandamuri Kalyan Ram | Kajal Aggarwal",
                    R.drawable.fifteen,"aJOTlE1K90k&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=13"
                )
            )
            add(
                NewList(
                    "Vivegam - Kadhalaada Official Song Video | Ajith Kumar | Anirudh",
                    R.drawable.sixteen,"OPf0YbXqDm0&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=14"
                )
            )
            add(
                NewList(
                    "Thuppaki - Google Google | Video Song | Vijay, Kajal Agarwal",
                    R.drawable.seventeen,"kOkQ4T5WO9E&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=15"
                )
            )
            add(
                NewList(
                    "Thuppaki - Google Google | Video Song | Vijay, Kajal Agarwal",
                    R.drawable.eighteen,"FM7MFYoylVs&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=16"
                )
            )
            add(
                NewList(
                    "Mersal - Maacho Tamil Video | Vijay, Kajal Aggarwal",
                    R.drawable.nineteen,"5GL9JoH4Sws&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=17"
                )
            )
            add(
                NewList(
                    "Yaakai Thiri - Full Tamil Video Song || Siddharth , Trisha",
                    R.drawable.twenty,"PMivT7MJ41M&list=RDCLAK5uy_lGEOjy5U8xV41C8_LyqNnAZKOH6sGyutI&index=18"
                )
            )


        }
    }


    data class NewList(val title: String, val image: Int,val videoId:String)


}

