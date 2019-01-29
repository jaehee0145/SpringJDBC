package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.Board;
import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {
    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/list")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page, Model model) {
        List<Board> boards = boardService.getBoards(page);
        model.addAttribute("boards", boards);
        return "boardlist";
    }

    @GetMapping("/view")
    public String view(
            @RequestParam(name = "id", required = false) Long id, Model model){
        Board board = boardService.getBoard(id);
        model.addAttribute("board", board);
        return "view";


    }

    @GetMapping("/write")
    public String writeform() {
        return "writeform";
    }

    @PostMapping("/board/write")
    public String write(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "content") String content,
            HttpSession session) {

        Board board = new Board();
        User user = (User) session.getAttribute("logininfo");

        board.setUserId(user.getId());
        board.setTitle(title);
        board.setContent(content);
        board.setNickname(user.getNickname());

        System.out.println(user.getId());
        System.out.println(title);

        boardService.addBoard(board);
        return "redirect:/board/list";
    }




}