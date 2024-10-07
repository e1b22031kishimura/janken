package oit.is.z2310.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JankenController {

  @PostMapping("/janken")
  public String Janken(@RequestParam("username") String username, ModelMap model) {
    model.addAttribute("username", username);
    return "janken.html";
  }

  @GetMapping("/janken")
  public String Janken() {
    return "janken.html";

  }

  @GetMapping("/battle")
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

    model.addAttribute("userHand", userHand);
    model.addAttribute("cpuHand", cpuHand);
    model.addAttribute("result", result);

    return "janken.html";
  }

}
