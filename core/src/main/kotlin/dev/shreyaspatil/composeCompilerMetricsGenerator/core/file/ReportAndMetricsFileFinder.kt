/**
 * MIT License
 *
 * Copyright (c) 2022 Shreyas Patil
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.shreyaspatil.composeCompilerMetricsGenerator.core.file

import java.io.File

/**
 * Finds reports and metrics files generated by Compose compiler
 *
 * @param directory The directory in which files will be searched
 */
class ReportAndMetricsFileFinder(directory: File) {
    private val allFiles =
        directory
            .listFiles()
            ?.filterNotNull()
            ?: emptyList()

    fun findBriefStatisticsJsonFile(): List<File> {
        return allFiles.filter { it.name.endsWith(FileSuffixes.MODULE_REPORT_JSON) }
    }

    fun findDetailsStatisticsCsvFile(): List<File> {
        return allFiles.filter { it.name.endsWith(FileSuffixes.COMPOSABLES_STATS_METRICS_CSV) }
    }

    fun findComposablesReportTxtFile(): List<File> {
        return allFiles.filter { it.name.endsWith(FileSuffixes.COMPOSABLES_REPORT_TXT) }
    }

    fun findClassesReportTxtFile(): List<File> {
        return allFiles.filter { it.name.endsWith(FileSuffixes.CLASSES_REPORT_TXT) }
    }

    object FileSuffixes {
        const val CLASSES_REPORT_TXT = "-classes.txt"
        const val COMPOSABLES_REPORT_TXT = "-composables.txt"
        const val COMPOSABLES_STATS_METRICS_CSV = "-composables.csv"
        const val MODULE_REPORT_JSON = "-module.json"
    }
}
