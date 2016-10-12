package com.cc.framework.web.admin;

import java.util.Collection;

import net.sf.ehcache.config.Searchable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cc.framework.util.Constants;
import com.cc.framework.web.BaseController;

@Controller
@RequestMapping("/admin/sessions")
public class SessionController extends BaseController{
	
	@Autowired  
    private SessionDAO sessionDAO;  
    @RequestMapping("index")  
    public String list(Model model) {
        Collection<Session> sessions =  sessionDAO.getActiveSessions();  
        model.addAttribute("sessions", sessions);  
        model.addAttribute("sesessionCount", sessions.size());  
        return "admin/sessions/list";  
    } 
    
    @RequestMapping("/{sessionId}/forceLogout")
    public String forceLogout(@PathVariable("sessionId") String sessionId,   
        RedirectAttributes redirectAttributes) {  
        try {  
            Session session = sessionDAO.readSession(sessionId);  
            if(session != null) {
                session.setAttribute(  
                    Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);  
            }  
        } catch (Exception e) {/*ignore*/}  
        redirectAttributes.addFlashAttribute("msg", "强制退出成功！");  
        return "redirect:/sessions";  
    }  
}
