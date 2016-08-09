/*
  This file is licensed to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package ch.vvingolds.xsdiff.format;

import java.util.List;

import com.google.common.collect.Lists;

public class NodeChangesHolder implements SemanticNodeChanges {

    private final String parentNodeNext;

    private final List<String> addedNodeText = Lists.newArrayList();

    private final List<String> removedNodeText = Lists.newArrayList();

    private DaisyDiffFormatter daisyDiff;

    private HistogramDiffFormatter histogramDiff;

    public NodeChangesHolder( final String parentNodeNext ) {
        super();
        this.parentNodeNext = parentNodeNext;
    }

    public void addedNode( final String nodeText ) {
        addedNodeText.add( nodeText );
    }

    public void removedNode( final String nodeText ) {
        removedNodeText.add( nodeText );
    }

    @Override
    public String getParentNodeNext() {
        return parentNodeNext;
    }

    @Override
    public List<String> getAddedNodes() {
        return addedNodeText;
    }

    @Override
    public List<String> getRemovedNodes() {
        return removedNodeText;
    }

    @Override
    public ContentHandlerFormatter getDaisyDiff() {
        if( daisyDiff == null ) {
            return new EmptyDiff();
        }
        return daisyDiff;
    }

    public void setDaisyDiff( final DaisyDiffFormatter daisyDiff ) {
        this.daisyDiff = daisyDiff;
    }

    @Override
    public DiffOutputFormatter getHistogramDiff() {
        if( histogramDiff == null ) {
            return new EmptyDiff();
        }
        return histogramDiff;
    }

    public void setHistogramDiff( final HistogramDiffFormatter histogramDiff ) {
        this.histogramDiff = histogramDiff;
    }

}