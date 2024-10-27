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
import oit.is.z2310.kaizi.janken.model.Match;
import oit.is.z2310.kaizi.janken.model.MatchMapper;
import oit.is.z2310.kaizi.janken.model.MatchInfo;
import oit.is.z2310.kaizi.janken.model.MatchInfoMapper;

@Controller
// @RequestMapping("janken")
public class JankenController {

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchinfoMapper;

  @GetMapping("/janken")
  public String Janken(ModelMap model) {
    ArrayList<User> users = userMapper.selectAllUsers();
    ArrayList<Match> matches = matchMapper.selectAllmatches();

    model.addAttribute("users", users);
    model.addAttribute("matches", matches);

    return "janken.html";
  }

  @GetMapping("/match")
  public String Match(@RequestParam Integer id, ModelMap model) {
    User user = userMapper.selectById(id);

    model.addAttribute("user", user);

    return "match.html";
  }

  @GetMapping("/fight")
  public String fight(@RequestParam("hand") String userHand,
      @RequestParam Integer id, ModelMap model, Principal prin) {
    String cpuHand = "グー";
    String result;
    String loginUser = prin.getName();
    User user1 = userMapper.selectByName(loginUser);
    User user2 = userMapper.selectById(id);
    MatchInfo matchinfo = new MatchInfo();

    matchinfo.setUser1(user1.getId());
    matchinfo.setUser2(id);
    matchinfo.setUser1Hand(userHand);
    matchinfo.setisActive(true);

    matchinfoMapper.insertMatchInfo(matchinfo);

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
    model.addAttribute("user", user2);

    return "wait.html";
  }

}
