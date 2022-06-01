package ru.itis.hastecloud.dtos.forms

data class AddCommentaryForm (var fileId: Long, var text: String, var userId: Long)