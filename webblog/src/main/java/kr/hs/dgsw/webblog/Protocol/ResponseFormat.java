package kr.hs.dgsw.webblog.Protocol;

import lombok.Data;

@Data
public class ResponseFormat {
  private int code; // 응답 코드
  private String desc; // 응답 메시지
  private Object data; // 응답 데이터

  // 특정 데이터만 조회한 경우 데이터의 ID를 option으로 받아 메시지에 삽입
  public ResponseFormat(ResponseType rt, Object data, Object option) {
    this.code = rt.code();
    this.desc = option instanceof Long || option instanceof String ? String.format(rt.desc(), option) : rt.desc();
    this.data = data;
  }

  // 전체 조회와 같은 경우 option 없이 코드, 메시지, 데이터만 세팅
  public ResponseFormat(ResponseType rt, Object data) {
    this(rt, data, null);
  }
}