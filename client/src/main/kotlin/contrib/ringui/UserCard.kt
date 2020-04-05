package contrib.ringui

import react.RBuilder
import react.RClass
import react.RHandler
import react.RProps

@JsModule("@jetbrains/ring-ui/components/user-card/user-card")
private external object UserCardModule {
    val UserCard: RClass<UserCardProps>
}

// https://github.com/JetBrains/ring-ui/blob/master/components/user-card/card.js
external interface UserCardProps : RProps {
    var user: UserCardModel
}

data class UserCardModel(
    val name: String,
    val login: String,
    val avatarUrl: String
)

fun RBuilder.ringUserCard(user: UserCardModel, handler: RHandler<UserCardProps> = {}) {
    UserCardModule.UserCard {
        attrs.user = user
        handler()
    }
}