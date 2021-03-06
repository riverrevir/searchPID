package search.ship.babel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import search.ship.babel.domain.*;
import search.ship.babel.dto.symbol.SymbolInfoResponse;
import search.ship.babel.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SymbolSearchService {
    private final ClassificationRepository classificationRepository;
    private final SymbolRepository symbolRepository;
    private final DSMEImageRepository dsmeImageRepository;
    private final AKERImageRepository akerImageRepository;
    private final KBRImageRepository kbrImageRepository;
    private final TECHNIPImageRepository technipImageRepository;

    public List<SymbolInfoResponse> getListByClassification(String classificationName) {
        List<SymbolInfoResponse> symbolInfoResponses = new ArrayList<>();
        Classification classification = classificationRepository.findByClassificationName(classificationName).orElseThrow(() -> new IllegalArgumentException("해당 분류는 존재하지 않습니다."));
        List<Symbol> symbols = symbolRepository.findBySymbolCodeStartsWith(classification.getClassificationCode());
        symbols.forEach(symbol -> {
            List<DSMEImage> dsmeImages = dsmeImageRepository.findBySymbolCode(symbol.getSymbolCode());
            List<AKERImage> akerImages = akerImageRepository.findBySymbolCode(symbol.getSymbolCode());
            List<KBRImage> kbrImages = kbrImageRepository.findBySymbolCode(symbol.getSymbolCode());
            List<TECHNIPImage> technipImages = technipImageRepository.findBySymbolCode(symbol.getSymbolCode());
            dsmeImages.forEach(dsmeImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "dsme", dsmeImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
            akerImages.forEach(akerImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Aker", akerImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
            kbrImages.forEach(kbrImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "KBR", kbrImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
            technipImages.forEach(technipImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Technip", technipImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
        });
        return symbolInfoResponses;
    }

    public List<SymbolInfoResponse> getListByClassificationAndSymbolName(String classificationName, String symbolName) {
        List<SymbolInfoResponse> symbolInfoResponses = new ArrayList<>();
        Classification classification = classificationRepository.findByClassificationName(classificationName).orElseThrow(() -> new IllegalArgumentException("해당 분류가 없습니다."));
        Symbol symbol = symbolRepository.findBySymbolName(symbolName).orElseThrow(() -> new IllegalArgumentException("해당 심볼명이 없습니다."));

        List<DSMEImage> dsmeImages = dsmeImageRepository.findBySymbolCode(symbol.getSymbolCode());
        List<AKERImage> akerImages = akerImageRepository.findBySymbolCode(symbol.getSymbolCode());
        List<KBRImage> kbrImages = kbrImageRepository.findBySymbolCode(symbol.getSymbolCode());
        List<TECHNIPImage> technipImages = technipImageRepository.findBySymbolCode(symbol.getSymbolCode());

        dsmeImages.forEach(dsmeImage -> {
            SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "dsme", dsmeImage);
            symbolInfoResponses.add(symbolInfoResponse);
        });
        akerImages.forEach(akerImage -> {
            SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Aker", akerImage);
            symbolInfoResponses.add(symbolInfoResponse);
        });
        kbrImages.forEach(kbrImage -> {
            SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "KBR", kbrImage);
            symbolInfoResponses.add(symbolInfoResponse);
        });
        technipImages.forEach(technipImage -> {
            SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Technip", technipImage);
            symbolInfoResponses.add(symbolInfoResponse);
        });
        return symbolInfoResponses;
    }

    public List<SymbolInfoResponse> getListByClassificationAndSymbolNameAndDesignerName(String classificationName, String symbolName, String designerName) {
        List<SymbolInfoResponse> symbolInfoResponses = new ArrayList<>();
        Classification classification = classificationRepository.findByClassificationName(classificationName).orElseThrow(() -> new IllegalArgumentException("해당 분류가 없습니다."));
        Symbol symbol = symbolRepository.findBySymbolName(symbolName).orElseThrow(() -> new IllegalArgumentException("해당 심볼명이 없습니다."));
        final String designerNameLower = designerName.toLowerCase();
        if (designerNameLower.equals("dsme")) {
            List<DSMEImage> dsmeImages = dsmeImageRepository.findBySymbolCode(symbol.getSymbolCode());
            dsmeImages.forEach(dsmeImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "dsme", dsmeImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
        } else if (designerNameLower.equals("aker")) {
            List<AKERImage> akerImages = akerImageRepository.findBySymbolCode(symbol.getSymbolCode());
            akerImages.forEach(akerImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Aker", akerImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
        } else if (designerNameLower.equals("kbr")) {
            List<KBRImage> kbrImages = kbrImageRepository.findBySymbolCode(symbol.getSymbolCode());
            kbrImages.forEach(kbrImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "KBR", kbrImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });

        } else if (designerNameLower.equals("technip")) {
            List<TECHNIPImage> technipImages = technipImageRepository.findBySymbolCode(symbol.getSymbolCode());
            technipImages.forEach(technipImage -> {
                SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Technip", technipImage);
                symbolInfoResponses.add(symbolInfoResponse);
            });
        }
        return symbolInfoResponses;
    }

    public List<SymbolInfoResponse> getListByClassificationAndDesignerName(String classificationName, String designerName) {
        List<SymbolInfoResponse> symbolInfoResponses = new ArrayList<>();
        Classification classification = classificationRepository.findByClassificationName(classificationName).orElseThrow(() -> new IllegalArgumentException("해당 분류가 없습니다."));
        List<Symbol> symbols = symbolRepository.findBySymbolCodeStartsWith(classification.getClassificationCode());
        final String designerNameLower = designerName.toLowerCase();
        if (designerNameLower.equals("dsme")) {
            symbols.forEach(symbol -> {
                List<DSMEImage> dsmeImages = dsmeImageRepository.findBySymbolCode(symbol.getSymbolCode());
                dsmeImages.forEach(dsmeImage -> {
                    SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "dsme", dsmeImage);
                    symbolInfoResponses.add(symbolInfoResponse);
                });
            });
        } else if (designerNameLower.equals("aker")) {
            symbols.forEach(symbol -> {
                List<AKERImage> akerImages = akerImageRepository.findBySymbolCode(symbol.getSymbolCode());
                akerImages.forEach(akerImage -> {
                    SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Aker", akerImage);
                    symbolInfoResponses.add(symbolInfoResponse);
                });
            });
        } else if (designerNameLower.equals("kbr")) {
            symbols.forEach(symbol -> {
                List<KBRImage> kbrImages = kbrImageRepository.findBySymbolCode(symbol.getSymbolCode());
                kbrImages.forEach(kbrImage -> {
                    SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "KBR", kbrImage);
                    symbolInfoResponses.add(symbolInfoResponse);
                });
            });
        } else if (designerNameLower.equals("technip")) {
            symbols.forEach(symbol -> {
                List<TECHNIPImage> technipImages = technipImageRepository.findBySymbolCode(symbol.getSymbolCode());
                technipImages.forEach(technipImage -> {
                    SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Technip", technipImage);
                    symbolInfoResponses.add(symbolInfoResponse);
                });
            });
        }
        return symbolInfoResponses;
    }

    public List<SymbolInfoResponse> getListByDesignerName(String designerName) {
        final String designerNameLower = designerName.toLowerCase();
        List<SymbolInfoResponse> symbolInfoResponses = new ArrayList<>();
        List<Classification> classifications = classificationRepository.findAll();
        classifications.forEach(classification -> {
            List<Symbol> symbols = symbolRepository.findBySymbolCodeStartsWith(classification.getClassificationCode());
            symbols.forEach(symbol -> {
                if (designerNameLower.equals("dsme")) {
                    List<DSMEImage> dsmeImages = dsmeImageRepository.findBySymbolCode(symbol.getSymbolCode());
                    dsmeImages.forEach(dsmeImage -> {
                        SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "dsme", dsmeImage);
                        symbolInfoResponses.add(symbolInfoResponse);
                    });
                } else if (designerNameLower.equals("aker")) {
                    List<AKERImage> akerImages = akerImageRepository.findBySymbolCode(symbol.getSymbolCode());
                    akerImages.forEach(akerImage -> {
                        SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Aker", akerImage);
                        symbolInfoResponses.add(symbolInfoResponse);
                    });
                } else if (designerNameLower.equals("kbr")) {
                    List<KBRImage> kbrImages = kbrImageRepository.findBySymbolCode(symbol.getSymbolCode());
                    kbrImages.forEach(kbrImage -> {
                        SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "KBR", kbrImage);
                        symbolInfoResponses.add(symbolInfoResponse);
                    });
                } else if (designerNameLower.equals("technip")) {
                    List<TECHNIPImage> technipImages = technipImageRepository.findBySymbolCode(symbol.getSymbolCode());
                    technipImages.forEach(technipImage -> {
                        SymbolInfoResponse symbolInfoResponse = SymbolInfoResponse.from(classification, symbol, "Technip", technipImage);
                        symbolInfoResponses.add(symbolInfoResponse);
                    });
                }
            });
        });
        return symbolInfoResponses;
    }
}
