/**
 * 2<=id_list<=1000 이용자 아이디 가 담긴 문자열 배열
 * 1<=report<=200,000 각 이용자 가 신고한 이용자 ID 정보 가 담긴 문자열 배열
 * k : 정지 기준되는 신고 횟수
 * 각 유저별로 처리 결과 ,메일을 받은 횟수를 배열로 return
 */



class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var id = id_list.toList()
        var reportMaps = mutableMapOf<String,Int>()
        var resultMaps = mutableMapOf<String,Int>()
        var checkReport = listOf<String>()
        //Maps 초기화
        for(i in id.indices){
            reportMaps.put(id[i],0)
            resultMaps.put(id[i],0)
        }
        // 신고 갯수 파악하기
        for(i in report.indices){
            checkReport = report[i].split(" ")
            //checkReport[0] 신고자 checkReport[1] 제제 대상
            reportMaps.replace(checkReport[1], reportMaps.get(checkReport[1])?.plus(1)!!)
        }
        // 일정 값 넘으면 해당되는 사람에게 보낼메세지를 계산
        var result = reportMaps.filter{it.value>=k}.map{it.key}
        for(i in report.indices){
            checkReport = report[i].split(" ")
            if(result.contains(checkReport[1])){
                resultMaps.put(checkReport[0],resultMaps.get(checkReport[0])?.plus(1)!!)
            }
        }
        return answer
    }
}
fun main(){

    var a = Solution()

    a.solution(arrayOf("muzi", "frodo", "apeach", "neo"), arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),2)
    //[2,1,1,0]
    a.solution(arrayOf("con", "ryan"), arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),3)
    //[0]
}