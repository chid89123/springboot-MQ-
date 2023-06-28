package com.imooc.mall;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.exception.UserLoginException;
import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * true 表示继续流程 false表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user == null) {
            log.info("user=null");
            throw new UserLoginException();
            //return ResponseVo.error(ResponseEnum.NEED_LOGIN);
            //response.getWriter().print("error");
            //return false;
        }
        //return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }
}
