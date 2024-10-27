package oit.is.z2310.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z2310.kaizi.janken.model.Entry;

import oit.is.z2310.kaizi.janken.model.User;
import oit.is.z2310.kaizi.janken.model.UserMapper;

@Controller
@RequestMapping("/janken")
public class JankenController {

  @Autowired
  UserMapper userMapper;

  @GetMapping
  public String redirectToStep1() {
    return "redirect:/janken/step1";
  }

  @GetMapping("step1")
  public String Janken(ModelMap model) {
    ArrayList<String> userNames = userMapper.selectAllUserName();
    model.addAttribute("userNames", userNames);

    return "janken.html";
  }

  /*
   * @GetMapping("battle")
   * public String battle(@RequestParam("hand") String userHand, ModelMap model) {
   * String cpuHand = "グー";
   * String result;
   *
   * if (userHand.equals(cpuHand)) {
   * result = "引き分け";
   * } else if ((userHand.equals("グー") && cpuHand.equals("チョキ")) ||
   * (userHand.equals("チョキ") && cpuHand.equals("パー")) ||
   * (userHand.equals("パー") && cpuHand.equals("グー"))) {
   * result = "勝ち";
   * } else {
   * result = "負け";
   * }
   *
   * model.addAttribute("room", this.room);
   * model.addAttribute("userHand", userHand);
   * model.addAttribute("cpuHand", cpuHand);
   * model.addAttribute("result", result);
   *
   * return "janken.html";
   * }
   */

}
