package com.inflames1986.mvplesson.model

import io.reactivex.rxjava3.core.Single
import java.util.concurrent.TimeUnit

class GithubUsersRepo {
    private val userPlug = GithubUserAdvanced(
        "Alex",
        1,
        "MDQ6VXNlcjE=",
        "https://avatars.githubusercontent.com/u/1?v=4",
        "",
        "https://api.github.com/users/alex",
        "https://github.com/alex",
        "https://api.github.com/users/alexey/followers",
        "https://api.github.com/users/alexey/following{/other_user}",
        "https://api.github.com/users/alexey/gists{/gist_id}",
        "https://api.github.com/users/alexey/starred{/owner}{/repo}",
        "https://api.github.com/users/alexey/subscriptions",
        "https://api.github.com/users/alexey/orgs",
        "https://api.github.com/users/alexey/repos",
        "https://api.github.com/users/alexey/events{/privacy}",
        "https://api.github.com/users/alexey/received_events",
        "User",
        false,
        "Alexus Maximus",
        "freelancer",
        "http://instagram.com",
        "Sevastopol",
        "alexey@google.com",
        true,
        "Eto Alexey",
        "AlexH",
        32,
        2,
        20,
        5,
        "2020-10-26T19:49:06Z",
        "2021-08-11T20:44:38Z"
    )

    private val repositories = listOf(
        GithubUser(
            "Alexey",
            1,
            "MDQ6VXNlcjE=",
            "https://avatars.githubusercontent.com/u/1?v=4",
            "",
            "https://api.github.com/users/alexey",
            "https://github.com/user",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Andrew",
            2,
            "MDQ6VXNlcjI=",
            "https://avatars.githubusercontent.com/u/2?v=4",
            "",
            "https://api.github.com/users/andrew",
            "https://github.com/andrew",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Stan",
            3,
            "MDQ6VXNlcjM=",
            "https://avatars.githubusercontent.com/u/3?v=4",
            "",
            "https://api.github.com/users/Stan",
            "https://github.com/Stan",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Swanson",
            4,
            "MDQ6VXNlcjQ=",
            "https://avatars.githubusercontent.com/u/4?v=4",
            "",
            "https://api.github.com/users/Swanson",
            "https://github.com/Swanson",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Steve",
            5,
            "MDQ6VXNlcjU=",
            "https://avatars.githubusercontent.com/u/5?v=4",
            "",
            "https://api.github.com/users/Steve",
            "https://github.com/Steve",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Dan",
            6,
            "MDQ6VXNlcjY=",
            "https://avatars.githubusercontent.com/u/6?v=4",
            "",
            "https://api.github.com/users/Dan",
            "https://github.com/Dan",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Mike",
            7,
            "MDQ6VXNlcjc=",
            "https://avatars.githubusercontent.com/u/7?v=4",
            "",
            "https://api.github.com/users/Mike",
            "https://github.com/Mike",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Matvey",
            17,
            "MDQ6VXNlcjE3",
            "https://avatars.githubusercontent.com/u/17?v=4",
            "",
            "https://api.github.com/users/Matvey",
            "https://github.com/Matvey",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Olga",
            18,
            "MDQ6VXNlcjE4",
            "https://avatars.githubusercontent.com/u/18?v=4",
            "",
            "https://api.github.com/users/Olga",
            "https://github.com/Olga",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Helena",
            19,
            "MDQ6VXNlcjE5",
            "https://avatars.githubusercontent.com/u/19?v=4",
            "",
            "https://api.github.com/users/Helena",
            "https://github.com/Helena",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Anna",
            20,
            "MDQ6VXNlcjIw",
            "https://avatars.githubusercontent.com/u/20?v=4",
            "",
            "https://api.github.com/users/Anna",
            "https://github.com/Anna",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Alina",
            21,
            "MDQ6VXNlcjIx",
            "https://avatars.githubusercontent.com/u/21?v=4",
            "",
            "https://api.github.com/users/Alina",
            "https://github.com/Alina",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
        GithubUser(
            "Natalia",
            22,
            "MDQ6VXNlcjIy",
            "https://avatars.githubusercontent.com/u/22?v=4",
            "",
            "https://api.github.com/users/Natalia",
            "https://github.com/Natalia",
            "https://api.github.com/users/user/followers",
            "https://api.github.com/users/user/following{/other_user}",
            "https://api.github.com/users/user/gists{/gist_id}",
            "https://api.github.com/users/user/starred{/owner}{/repo}",
            "https://api.github.com/users/user/subscriptions",
            "https://api.github.com/users/user/orgs",
            "https://api.github.com/users/user/repos",
            "https://api.github.com/users/user/events{/privacy}",
            "https://api.github.com/users/user/received_events",
            "User",
            false
        ),
    )

    fun getUsers(): Single<List<GithubUser>> {
        return Single.just(repositories).delay(5L, TimeUnit.SECONDS)
    }

    fun getUserById(id: Int): Single<GithubUserAdvanced> {
        // для тестирования выдаю конкретный результат без привязки id (пока)
        val ss: Single<GithubUserAdvanced>
        if (id == 3) {
            ss = Single.error(Throwable("Запланированная ошибка"))
        } else {
            ss = Single.just(userPlug).delay(3L, TimeUnit.SECONDS)
        }
        return ss
    }
}