package com.diy.domain

import java.util.UUID

import com.diy.domain.Alias._


object Alias {
  type Description = String
  type Title = String
  type HeadLine = String
  type SeqNumber = Int
  type Tag = String
}


case class Task(id: Option[UUID], seqNumber: SeqNumber, headLine: HeadLine, description: Description)

case class Project(id: Option[UUID], title: Title, description: Description, tasks: Seq[Task], user: User, tags: Seq[Tag])
