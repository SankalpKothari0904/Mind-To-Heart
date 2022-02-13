package com.example.mindtoheart.data

import com.example.mindtoheart.R

class Datasource_acad_single {
    fun loadQuestions(): List<questions> {
        return listOf<questions>(
            questions(
                R.string.q1academics,
                option(R.string.option_always),
                option(R.string.option_often),
                option(
                    R.string.option_rare
                ),
                option(R.string.option_never),
                R.drawable.acadassignments
            ),
            questions(
                R.string.q2academics,
                option(R.string.option_splendid),
                option(R.string.option_nice),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_bad),
                R.drawable.classmates
            ),
            questions(
                R.string.q3academics,
                option(R.string.option_never),
                option(R.string.option_rare),
                option(
                    R.string.option_often
                ),
                option(R.string.option_always),
                R.drawable.acadsleepcycle
            ),
            questions(
                R.string.q4academics,
                option(R.string.option_always),
                option(R.string.option_often),
                option(
                    R.string.option_rare
                ),
                option(R.string.option_never),
                R.drawable.grades
            ),
            questions(
                R.string.q5academics,
                option(R.string.option_never),
                option(R.string.option_rare),
                option(
                    R.string.option_often
                ),
                option(R.string.option_always),
                R.drawable.acadoverworked
            ),
            questions(
                R.string.q6single,
                option(R.string.option_never),
                option(R.string.option_rare),
                option(
                    R.string.option_often
                ),
                option(R.string.option_always),
                R.drawable.lonelysingle
            ),
            questions(
                R.string.q7single,
                option(R.string.option_never),
                option(R.string.option_rare),
                option(
                    R.string.option_often
                ),
                option(R.string.option_always),
                R.drawable.datingapps
            ),
            questions(
                R.string.q8single,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.freedom
            ),
            questions(
                R.string.q9single,
                option(R.string.option_disagree),
                option(R.string.option_neutral),
                option(
                    R.string.option_agree
                ),
                option(R.string.option_strongly_agree),
                R.drawable.relationshipimportant
            ),
            questions(
                R.string.q10single,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.happysingle
            ),
            questions(
                R.string.q11, option(R.string.option_never), option(R.string.option_rare), option(
                    R.string.option_often
                ), option(R.string.option_always),
                R.drawable.parentpressure
            ),
            questions(
                R.string.q12, option(R.string.option_never), option(R.string.option_rare), option(
                    R.string.option_often
                ), option(R.string.option_always),
                R.drawable.peerpressure
            ),
            questions(
                R.string.q13,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.satisfiedfriends
            ),
            questions(
                R.string.q14,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.support
            ),
            questions(
                R.string.q15,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.parentsupport
            ),
            questions(
                R.string.q16, option(R.string.option_never), option(R.string.option_rare), option(
                    R.string.option_often
                ), option(R.string.option_always),
                R.drawable.timespent
            ),
            questions(
                R.string.q17,
                option(R.string.option_disagree),
                option(R.string.option_neutral),
                option(
                    R.string.option_agree
                ),
                option(R.string.option_strongly_agree),
                R.drawable.socialskills
            ),
            questions(
                R.string.q18, option(R.string.option_never), option(R.string.option_rare), option(
                    R.string.option_often
                ), option(R.string.option_always),
                R.drawable.likes
            ),
            questions(
                R.string.q19,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.wiseinternet
            ),
            questions(
                R.string.q20, option(R.string.option_never), option(R.string.option_rare), option(
                    R.string.option_often
                ), option(R.string.option_always),
                R.drawable.gaming
            ),
            questions(
                R.string.q21, option(R.string.option_always), option(R.string.option_often), option(
                    R.string.option_rare
                ), option(R.string.option_never),
                R.drawable.bodyimage
            ),
            questions(
                R.string.q22, option(R.string.option_never), option(R.string.option_rare), option(
                    R.string.option_often
                ), option(R.string.option_always),
                R.drawable.selfworth
            ),
            questions(
                R.string.q23,
                option(R.string.option_disagree),
                option(R.string.option_neutral),
                option(
                    R.string.option_agree
                ),
                option(R.string.option_strongly_agree),
                R.drawable.opinions
            ),
            questions(
                R.string.q24,
                option(R.string.option_strongly_agree),
                option(R.string.option_agree),
                option(
                    R.string.option_neutral
                ),
                option(R.string.option_disagree),
                R.drawable.qualities
            ),
            questions(
                R.string.q25, option(R.string.option_always), option(R.string.option_often), option(
                    R.string.option_rare
                ), option(R.string.option_never),
                R.drawable.relaxed
            ),
        )
    }
}