package servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * Session对象
 *      Session表示一次会话，会话中可以有多次请求，会话保留指定时间段
 *      无论是客户端还是服务端，都能感知Session对象。（服务器和浏览器都会影响Session对象）
 *      获取Session对象 或 创建Session对象
 *          request.getSession()
 *          当Session对象存在时，表示获取Session对象；否则表示创建Session对象
 */

@WebServlet(name="se01", urlPatterns = ["/se01"])
class Session01 : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {

        // 创建或获取Session对象
        val session = req?.session

        // 获取会话标识符
        println("会话标识符：${session?.id}")
        // 是否是新的Session对象
        println("是否是新的Session对象：${session?.isNew}")
        // 会话开始时间
        println("会话开始时间：${session?.creationTime}" )
        // 最后一次访问时间
        println("最后一次访问时间：${session?.lastAccessedTime}")

    }
}