package servlet

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

/**
 * Session作用域
 *      1. 默认到期时间
 *          最大不活动时间，当指定时间内，没有做任何操作。
 *          Tomcat服务器设置session的最大不活动时间为30分钟。（单位：分钟）
 *          可以手动修改服务器的时间（不建议）
 *              在Tomcat安装包的conf目录中，对应web.xml文件
 *              <session-config>
 *                  <session-timeout>30</session-timeout>
 *              </session-config>
 *      2. 手动设置最大不活动时间
 *          设置最大不活动时间，单位：秒
 *              setMaxInactiveInterval(秒数)
 *          获取最大不活动时间
 *              getMaxInactiveInterval()
 *      3. 关闭浏览器
 *          session底层依赖浏览器，cookie默认关闭浏览器失效。
 *      4. 关闭服务器
 *          服务器关闭，session对象就销毁了
 *      5. 手动销毁
 *          session.invalidate()
 */

@WebServlet(name="se03", urlPatterns = ["/se03"])
class Session03 : HttpServlet() {
    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {

         // 创建或获取Session对象
        val session = req?.session

        // request作用域
        req?.setAttribute("requestMsg", "这是request的作用域")

        // session作用域
        session?.setAttribute("sessionMsg", "这是session的作用域")

//        // 请求转发
//        req?.getRequestDispatcher("index.jsp")?.forward(req, resp)

//        // 重定向
//        resp?.sendRedirect("index.jsp")

        println("Session标识符：${session?.id}")

        // 获取最大不活动时间
        println("最大不活动时间：${session?.maxInactiveInterval}")

        // 设置最大不活动时间
        session?.maxInactiveInterval = 100

        // 手动销毁
        session?.invalidate()

    }
}