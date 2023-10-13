package kr.co.sboard.service;

import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.dto.FileDTO;
import kr.co.sboard.dto.PageRequestDTO;
import kr.co.sboard.dto.PageResponseDTO;
import kr.co.sboard.entity.ArticleEntity;
import kr.co.sboard.repository.ArticleRepository;
import kr.co.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2 // 항상 로그 찍기
public class ArticleService {

    private  final ArticleRepository articleRepository;
    private final FileRepository fileRepository;
    private final ModelMapper modelMapper;

    public PageResponseDTO findByParentAndCate(PageRequestDTO pageRequestDTO){

        Pageable pageable = pageRequestDTO.getPageable("no"); // Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no");이거랑 같음


        //
        //Pageable pageable = PageRequest.of(pg-1, 10, Sort.Direction.DESC, "no"); // 글 10개 나오도록
        Page<ArticleEntity> result = articleRepository.findByParentAndCate(0, pageRequestDTO.getCate(), pageable); // parent 0은 본글이므로 댓글이 걸러짐

        // result.getContent() 리스트임, stream은 통로(pipeline) : 가공처리를 위함, map은 리스트 안에 객체수만큼 순회(for문과 같다)
        List<ArticleDTO> dtoList = result.getContent()
                                        .stream()
                                        .map(entity -> modelMapper.map(entity, ArticleDTO.class)) // entity와 ArticleDTO의 속성이 같아서 가능
                                        .toList();

        int totalElement = (int) result.getTotalElements();


        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }


    public void save(ArticleDTO dto){

        // 글 등록
        ArticleEntity savedEntity = articleRepository.save(dto.toEntity());

        // 파일 업로드
        FileDTO fileDTO = fileUpload(dto);

        if(fileDTO != null){
            // 파일 등록
            fileDTO.setAno(savedEntity.getNo());
            fileRepository.save(fileDTO.toEntity());
        }
    }

    @Value("${spring.servlet.multipart.location}")
    private String filePath;

    public FileDTO fileUpload(ArticleDTO dto){

        log.info("fileUpload...1");
        MultipartFile mf = dto.getFname();

        log.info("fileUpload...2 : " + mf);

        if(!mf.isEmpty()){
           // 파일 첨부했을 경우
            String path = new File(filePath).getAbsolutePath();
            log.info("fileUpload...3 : " + path);

            String oName = mf.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString()+ext;

            log.info("fileUpload...4 : " + oName);

            try {
                log.info("fileUpload...5");
                mf.transferTo(new File(path, sName));
                log.info("fileUpload...6");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            log.info("fileUpload...7");
            return FileDTO.builder().ofile(oName).sfile(sName).build();
        }
        log.info("fileUpload...8");
        return null;
    }

    public void delete(String no){
        articleRepository.deleteById(no); //Repository 고유 메서드 deleteById 는 String타입만 매개변수 가능
    }


}
