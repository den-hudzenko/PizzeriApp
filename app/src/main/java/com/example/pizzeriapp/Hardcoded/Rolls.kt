package com.example.pizzeriapp.Hardcoded

import com.example.pizzeriapp.R

val Rolls = listOf<Model>(
    Model(
        image = R.drawable.roll_tunec,
        price = 179,
        weight = 220,
        title = "Каліфорнія з тунцем",
        description = "Рис, норі, огірок, сир філадельфія, тунець, конжут, соус унагі",
        isNew = true,
        category = "Суші"
    ),
    Model(image = R.drawable.roll_california, price = 271, weight = 210, title = "Каліфорнія PRO", description = "Рис, норі, авокадо, огірок, лосось смажений, японський майонез, стружка тунця", isNew = true,        category = "Суші"),
    Model(image = R.drawable.roll_crab, price = 179, weight = 220, title = "Запечений краб", description = "Рис, норі, огірок, сир філадельфія, тунець, конжут, соус унагі", isNew = false,        category = "Суші")

)

val Pizza = listOf<Model>(
    Model(image = R.drawable.delux, price = 309, weight = 495, title = "Делюкс", description = "Соус вершковий, креветка тигрова, сир моцарела, салат чука, соус унагі", isNew = true, category = "Піца"),
    Model(image = R.drawable.buffallo, price = 330, weight = 495, title = "Буффало", description = "Соус песто, сир моцарела, сир рікота, помідор чері, телятина ростбіф, базилік", isNew = true, category = "Піца"),

)

val Sets = listOf<Model>(
    Model(image = R.drawable.set_baked, price = 1259, weight = 1300, title = "Сет Запечений", description = "Запечений краб, Запечена креветка, Запечена Філа", isNew = true, category = "Сети"),
    Model(image = R.drawable.set_spacie, price = 624, weight = 720, title = "Сет Спайсі", description = "Спайсі лосось, Спайсі тунець, Спайсі креветка", isNew = true, category = "Сети"),

)


val Another = listOf<Model>(
    Model(image = R.drawable.pepsi, price = 64, weight = 1000, title = "Пепсі (1 л.)", description = "1000 г", isNew = false, category = "Інше"),
    Model(image = R.drawable.tomato, price = 67, weight = 500, title = "Садочок томатний (0,5 л.)", description = "500 г", isNew = false,category = "Інше"),
    Model(image = R.drawable.fruit, price = 67, weight = 500, title = "Садочок фруктовий (0,5 л.)", description = "500 г", isNew = false,category = "Інше"),
    )