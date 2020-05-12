package com.elfak.museumapp.model

object MuseumData {
    //maps string to museum items, string on the left is what will be scanned with qr code
    val data = hashMapOf(
        "item1" to MuseumItem(
            "title1",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin eu tristique mi, sit amet mollis nunc. Duis lacus nulla, suscipit id purus suscipit, finibus posuere enim. Nunc lacinia erat ac dolor consectetur, ac posuere metus dictum. Integer odio ex, feugiat eu ultrices eget, sagittis nec nisl. Morbi dui erat, semper sed risus non, tincidunt semper purus. Integer vel mollis augue. Phasellus et blandit nunc. Nullam rutrum ultricies enim, ut pellentesque elit ullamcorper nec. Donec accumsan accumsan lacus, sit amet commodo lacus feugiat vel. Donec dignissim eros in libero suscipit laoreet. Nulla interdum magna mauris, eget hendrerit purus congue ac. Pellentesque in arcu imperdiet, dictum metus non, auctor odio. Ut et metus augue.",
            listOf(
                "https://dl.dropbox.com/s/essibmdi179wweg/image1.jpg?dl=0",
                "https://dl.dropbox.com/s/oa5vjrqz85ssa4s/image2.jpg?dl=0"
            )
        ),
        "item2" to MuseumItem(
            "title2",
            "Aenean nisl augue, faucibus sit amet justo in, luctus laoreet felis. Mauris eu est tortor. Phasellus interdum sapien libero, eu lobortis justo lacinia a. Sed euismod eros quis dolor lacinia facilisis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Sed ultrices quam tincidunt ligula porta, in varius est placerat. Ut dictum, lorem sed consectetur lacinia, augue orci aliquam felis, eget mattis sapien sapien mattis dui. Duis accumsan turpis eu dolor condimentum, id posuere felis pulvinar. Praesent eu leo ipsum. Cras efficitur nisl sed massa mattis interdum. Suspendisse non turpis et lacus elementum consectetur quis eu libero. Mauris scelerisque ac nisi quis placerat. Nam tempus ultrices odio a feugiat. Praesent eros nulla, mollis eget ultricies eu, sagittis sed odio. In a lacus magna. Vivamus convallis erat id ligula sodales, a tincidunt libero mattis.",
            listOf(
                "https://dl.dropbox.com/s/essibmdi179wweg/image1.jpg?dl=0",
                "https://dl.dropbox.com/s/oa5vjrqz85ssa4s/image2.jpg?dl=0"
            )
        ),
        "item3" to MuseumItem(
            "title3",
            "Duis bibendum ut arcu sed vehicula. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus tempor tristique ex ac accumsan. Mauris a metus eget purus mollis feugiat ut nec ex. Aenean pulvinar tellus non maximus tincidunt. Pellentesque id massa eu neque convallis semper. Aenean rhoncus tempor diam, quis pellentesque ipsum condimentum ut. Phasellus tempus lectus nec odio ullamcorper, ut blandit eros faucibus. Quisque placerat erat sed dui euismod consequat. Donec est dolor, facilisis sed vestibulum id, laoreet non eros. Nam in risus lacus. Donec convallis blandit tellus, in bibendum magna imperdiet ut.",
            listOf(
                "https://dl.dropbox.com/s/essibmdi179wweg/image1.jpg?dl=0",
                "https://dl.dropbox.com/s/oa5vjrqz85ssa4s/image2.jpg?dl=0"
            )
        )
    )
}