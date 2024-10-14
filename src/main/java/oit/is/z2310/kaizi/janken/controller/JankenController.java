package oit.is.z2310.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2310.kaizi.janken.model.Entry;

@Controller
@RequestMapping("/janken")
public class JankenController {

  @Autowired
  private Entry room;

  @GetMapping("step1")
  public String Janken(ModelMap model, Principal prin) {
    String loginUser = prin.getName();
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    return "janken.html";
  }

  @GetMapping("battle")
  public String battle(@RequestParam("hand") String userHand, ModelMap model) {
    String cpuHand = "グー";
    String result;

    if (userHand.equals(cpuHand)) {
      result = "引き分け";
    } else if ((userHand.equals("グー") && cpuHand.equals("チョキ")) ||
        (userHand.equals("チョキ") && cpuHand.equals("パー")) ||
        (userHand.equals("パー") && cpuHand.equals("グー"))) {
      result = "勝ち";
    } else {
      result = "負け";
    }

    model.addAttribute("room", this.room);
    model.addAttribute("userHand", userHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("result", result);

    return "janken.html";
  }

}
