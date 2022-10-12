package com.inflames1986.mvplesson.core.database

import androidx.room.Embedded
import androidx.room.Relation
import com.inflames1986.mvplesson.core.database.RepoDBObject
import com.inflames1986.mvplesson.core.database.UserDBObject

data class UserWithReposDBObject(
    @Embedded
    val userDBObject: UserDBObject,
    @Relation(
        parentColumn = UserDBObject.PRIMARY_KEY,
        entityColumn = RepoDBObject.FOREIGN_USER_KEY
    )
    val repos: List<RepoDBObject>
)