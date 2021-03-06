/**
 * Copyright 2019 Association for the promotion of open-source insurance software and for the establishment of open interface standards in the insurance industry (Verein zur Förderung quelloffener Versicherungssoftware und Etablierung offener Schnittstellenstandards in der Versicherungsbranche)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aposin.licensescout.execution;

import java.util.List;

import org.aposin.licensescout.configuration.OutputFileType;
import org.aposin.licensescout.exporter.IReportExporter;

/**
 * Factory interface for report exporters.
 *
 * @see IReportExporter
 * @see OutputFileType
 */
public interface IReportExporterFactory {

    /**
     * Obtains the list of output file types supported by this factory.
     * @return the list of output file types supported by this factory
     */
    List<OutputFileType> getSupportedOutputFileTypes();

    /**
     * Obtains a report exporter instance for a given output file type.
     * @param outputFileType an output file type
     * @return a report exporter instance
     */
    IReportExporter getReportExporter(OutputFileType outputFileType);

}