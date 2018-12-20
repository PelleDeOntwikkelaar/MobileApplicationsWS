library(rjson) 

print("Hello World!")

# https://blogazonia.wordpress.com/2014/05/08/import-multiple-files-to-r/

setwd("/Users/pellereyniers/IdeaProjects/MobileApplicationsWS/Json")

listfiles<-list.files(pattern=".json$")

for (i in listfiles){
    setwd("/Users/pellereyniers/IdeaProjects/MobileApplicationsWS/Json")
result <- fromJSON(file = i)

    avg = result$avg
    over = result$over
    ontime = result$ontime
    now = result$time

arrayst <- vector(mode="list", length=7)

arrayst[[1]] <- sum(avg)
arrayst[[2]] <- mean(avg)
arrayst[[3]] <- max(avg)
arrayst[[4]] <- min(avg[avg>0])
arrayst[[5]] <- sum(over)
arrayst[[6]] <- sum(ontime)
    arrayst[[7]] <- now

namepath = paste(substr(i, 0, 8), "proc.json", sep="_")
    setwd("/Users/pellereyniers/IdeaProjects/MobileApplicationsWS/JsonProc")
exportJson <- toJSON(arrayst)
write(exportJson, namepath)
}

min(my_data_frame[my_data_frame$my_column_number>0,my_column_number])