package org.zerock.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {
    //화면에서 전달되는 page라는 파라미터와 size라는 파라미터를 수집하는 역할.
    private int page;
    private int size;
    //진짜 목적 : jpa쪽에서 사용하는 Pageable 타입의 객체를 생성하는 것.
    public PageRequestDTO() {
        this.page= 1;
        this.size=10;
    }
    //정렬은 나중에 다양한 상황에서 쓰기 위해 별도의 파라미터로 받음
    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }


}
