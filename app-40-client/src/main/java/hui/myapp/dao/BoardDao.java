package hui.myapp.dao;

import hui.myapp.vo.Board;

import java.util.List;

public interface BoardDao {
    void add(Board board);

    int delete(int no);

    List<Board> findAll();

    Board findBy(int no);

    int update(Board board);
}
