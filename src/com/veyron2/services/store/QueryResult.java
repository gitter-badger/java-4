
// This file was auto-generated by the veyron vdl tool.
// Source: service.vdl
package com.veyron2.services.store;

import java.util.HashMap;

// QueryResult is a single level result.  If the query contained nested
// queries, they will be sent as subsequent QueryResults.  If the
// QueryResult is for a known type, the value is stored in Value.
// If the result is for a dynamic type using selection, Fields will
// be populated appropriately and Value will be nil.
//
// Examples
// 1) Return Team objects: "/teamsapp/teams".Query("*:Team")
//    QueryResult{
//      NestedResult: 0,
//      Name: "hornets",
//      Fields: nil,
//      Value: Team{Location: "CA", Mascot:"Buzz"},
//    },
//    QueryResult{
//      NestedResult: 0,
//      Name: "sharks",
//      Fields: nil,
//      Value: Team{Location: "NY", Mascot:"Jaws"},
//    }
//
// 2) Return just the mascot names: "/teamsapp/teams".Query("*:Team{Mascot}")
//    QueryResult{
//      NestedResult: 0,
//      Name: "hornets",
//      Fields: {"Mascot": "Buzz"},
//      Value: nil,
//    },
//    QueryResult{
//      NestedResult: 0,
//      Name: "sharks",
//      Fields: {"Mascot": "Jaws"},
//      Value: nil
//    }
//
// 3) Return the players for each team: "/teamsapp/teams".Query("*:Team{., players/*:Player")
//    QueryResult{
//      NestedResult: 0,
//      Name: "hornets",
//      Fields: {
//        ".": Team{Location: "CA", Mascot: "Buzz"},
//        // Any subsequent QueryResult with a NestedResult of 1 should be
//        // materialized in this field.
//        "players": NestedResult(1),
//      },
//      Value:nil
//    },
//    QueryResult{
//      NestedResult: 1,
//      Name: "John",
//      Fields: nil,
//      Value: Player{Age: 23, Hometown: "New York"},
//    },
//    QueryResult{
//      NestedResult: 1,
//      Name: "Julie",
//      Fields: nil,
//      Value: Player{Age: 24, Hometown: "Charlotte"},
//    },
//    QueryResult{
//      NestedResult: 0,
//      Name: "sharks",
//      Fields:
//        ".": Team{Location: "NY", Mascot: "Jaws"},
//        "players": NestedResult(2),
//      },
//      Value:nil
//    },
//    QueryResult{
//      NestedResult: 2,
//      Name: "Jamie",
//      Fields: nil,
//      Value: Player{Age: 20, Hometown: "Seattle"},
//    },
//    QueryResult{
//      NestedResult: 2,
//      Name: "Jacob",
//      Fields: nil,
//      Value: Player{Age: 25, Hometown: "Miami"},
//    }
//
// Nested results may in turn contain their own nested results.  A
// NestedResult value is always greater than the parent's NestedResult value.
// In a stream of results, a decrease in the NestedResult values means
// that the group is finished.  Here is an example result stream containing
// only the NestedResult values.  The parentheses show the grouping.
//  (0 (1 (2, 2), 1 (3), 1 (4, 4, 4)), (0 (1, 1 (5, 5)))
public class QueryResult { 
	// NestedResult, if non-zero, specifies which previous result contains
// this result.
public long nestedResult;
	// Name is the Veyron name of this value.  It is relative to the query
// root or, if NestedResult is non-zero, to the parent result.
public String name;
	// Fields will be non-nil if this query result is of a dynamic type
// specified by the selection operator. The keys will be the names
// used in the selection.  If a field represents a subquery, the
// value will be a NestedResult and subsequent QueryResults will
// have the same valued NestedResult.  See the example above.
public HashMap<String, java.lang.Object> fields;
	// Value will be non-nil if this query result is of a known type.
public java.lang.Object value;
}
