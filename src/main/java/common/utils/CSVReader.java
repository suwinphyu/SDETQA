package common.utils;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CSVReader {

    public static List<Map<String, String>> read(File file) throws IOException {
        List<Map<String, String>> output = new LinkedList<>();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',').withComments();
        MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class).with(schema).readValues(file);

        while (iterator.hasNext()) {
            output.add(iterator.next());
        }
        return output;
    }
}
